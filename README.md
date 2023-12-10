# Авто-тесты для демо-сайта Luma

---
* Проект предназначен для покрытия авто-тестами демо сайта [Luma](https://demo-magento-2.auroracreation.com/en/)

## Стек: Java | Selenium | TestNG 

---
* Проект разработан в соответствии с принципами Page Object Model (POM).
Наиболее очевидным преимуществом этого паттерна является простота поддержки тестов в случае изменений в UI.
####
* Чтобы запустить проект локально, необходимо установить [Maven](https://maven.apache.org/download.cgi) и [Java](https://www.java.com/download/ie_manual.jsp) на локальную машину. 
####
* В папке "resources" необходимо сделать копию файла "local.properties.TEMPLATE" и дать ей имя "local.properties".
####
* Команда для запуска тестов: `mvn clean test`
