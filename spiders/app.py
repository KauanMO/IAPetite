from flask import Flask, request, jsonify
import requests
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By

app = Flask(__name__)

options = Options()
# options.add_argument("--headless=new")

@app.route('/scrap-dishes', methods=['POST'])
def scrap_dishes():
    driver = webdriver.Chrome(options)
    data = request.get_json()
    tags = data.get('tags', [])
    page = data.get('page')
    
    driver.get(f'https://cybercook.com.br/search?q={"".join(tags)}&is_premium=true&calorias=0&custo=0&prep=0&page={page}')
    
    dish_cards = driver.find_elements(By.XPATH, '//*[@id="cc-container"]/div[3]/div/div/div[2]/div')
    
    print(dish_cards)
    
    driver.quit()
    
    return jsonify([])
    

if __name__ == '__main__':
    app.run(port=5001)