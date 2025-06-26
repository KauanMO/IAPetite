from flask import Flask, request
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By

app = Flask(__name__)

options = Options()
options.add_argument("--headless=new")

diets_dictionary = {
    "vegano": "vegana",
    "vegetariano": "vegetariana",
    "sem glúten": "sem_gluten",
    "sem glúten": "sem_gluten",
    "low-carb": "baixo_carbo"
}

@app.route('/scrap-dishes', methods=['POST'])
def scrap_dishes():
    driver = webdriver.Chrome(options)
    data = request.get_json()
    tags = data.get('tags', [])
    diets = data.get('diets', [])
    page = data.get('page')

    response = {}
    
    driver.get(f'https://cybercook.com.br/search?q={"".join(tags)}&is_premium=true&calorias=0&custo=0&prep=0&page={page}')
    
    dish_cards = driver.find_elements(By.XPATH, '//*[@id="cc-container"]/div[3]/div/div/div[2]/div')

    dishes = []

    page_controller_div = driver.find_element(By.XPATH, '//*[@id="cc-container"]/div[3]/div/div/div[3]/div[2]')

    response['totalPages'] = int(page_controller_div.find_element(By.TAG_NAME, 'a').text)

    for dish_card in dish_cards:
        try:
            href = dish_card.find_element(By.TAG_NAME, 'a').get_attribute('href')
            driver.execute_script(f'window.open("{href}", "_blank");')
            driver.switch_to.window(driver.window_handles[-1])

            dish = {}
            dish['name'] = driver.find_element(By.XPATH, '//*[@id="__next"]/div/div[2]/div/div[2]/main/h1').text
            dish['image'] = driver.find_element(By.XPATH, '//*[@id="__next"]/div/div[2]/div/div[2]/main/div[2]/div/div[2]/div/div/ul/li[1]/div/span/img').get_attribute('src')
            dish['ingredients'] = []
            dish['howToSteps'] = []

            ingredient_divs = driver.find_elements(By.XPATH, '//*[@id="__next"]/div/div[2]/div/div[2]/main/div[3]/div/div')

            for ingredient_div in ingredient_divs:
                dish['ingredients'].append(ingredient_div.find_element(By.TAG_NAME, 'p').text)

            how_to_divs = driver.find_element(By.XPATH, '//*[@id="__next"]/div/div[2]/div/div[2]/main/div[4]/div/ul')

            how_tos = how_to_divs.find_elements(By.TAG_NAME, 'p')

            for how_to in how_tos:
                dish['howToSteps'].append(how_to.text)

            dishes.append(dish)
        except:
            print('Error')

        driver.close()
        driver.switch_to.window(driver.window_handles[0])
    
    driver.quit()

    response['dishes'] = dishes
    
    return response
    

if __name__ == '__main__':
    app.run(port=5001)