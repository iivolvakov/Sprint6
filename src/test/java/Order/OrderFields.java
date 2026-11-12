//ТЕСТ ЗАКАЗА САМОКАТА — ЧЕК-ЛИСТ И ЛОКАТОРЫ
//Сайт: https://qa-scooter.education-services.ru/
//-----------------------------------------------
//Сценарий
//1. Открыть главную страницу
//2. Закрыть баннер cookie
//3. Начать заказ верхней кнопкой или нижней кнопкой
//4. Заполнить имя, фамилию, адрес, станцию метро, телефон
//5. Нажать «Далее»
  //      6. Выбрать дату доставки, срок аренды, цвет самоката; заполнить комментарий
  //      7. Нажать кнопку оформления заказа
  //      8. Подтвердить заказ в диалоге
  //      9. Проверить, что показалось сообщение об успешном создании заказа
//-----------------------------------------------
//1) Кнопка "Заказать" в верхней панели главной страницы https://qa-scooter.education-services.ru/:
//   locator:By.cssSelector("button.Button_Button__ra12g")
//2) Кнопка "Заказать" по середине главной страницы:
//   locator:  By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM")

//Переход на страницу оформления заказа(https://qa-scooter.education-services.ru/order):

//3)Поле ввода "Имя":
//   locator: By.cssSelector("input[placeholder='* Имя']")
//4)Поле ввода "Фамилия":
//   locator: By.cssSelector("input[placeholder='* Фамилия']")
//5)Поле ввода адреса доставки
//   locator: By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']")
//6)Поле выбора станции метро:
//   locator: By.cssSelector("input[placeholder='* Станция метро']")
//6.5)Выбор станции метро после нажатия на поле
//   locator By.xpath("//button[normalize-space()='Сокольники']")
//7) Поле ввода номера
//   locator: cBy.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']")
//7.5)Кнопка перехода "Далее"
// locator: By.xpath("//button[normalize-space()='Далее']")

//-----------------------------------------------

//  Переход на следующую страницу
//8) Поле «Когда привезти самокат» — чтобы открыть календарь.
//   locator: By.cssSelector("input[placeholder='* Когда привезти самокат']")
//9)Поиск поля календаря
//   locator: By.cssSelector(".react-datepicker__month-container")
//10)// Кнопки смены месяца; доступные подписи подтверждены как Previous Month / Next Month
//By.cssSelector("button[aria-label='Previous Month']")
//By.cssSelector("button[aria-label='Next Month']")
//11)Кнопка выбора дня недели
//   locator: className="react-datepicker__day-name"
//12)Кнопка выбора дня в месяце
//   locator: className="react-datepicker__week"
//13)// Чекбокс цвета «чёрный жемчуг»; id подтверждён в доступном дереве
//By.id("black")
//Чекбокс цвета «серая безысходность»; id подтверждён в доступном дереве
//By.id("grey")
//14)Поле ввода коммнетарий для курьера
//  locator: By.cssSelector("textarea[placeholder='Комментарий для курьера']")
// На шаге 2 присутствует кнопка «Заказать»;
// By.xpath("//button[normalize-space()='Заказать']")
// 16)Подтвердить заказа
// By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM")
//17)Проверить появление текста после нажатия кнопки Заказать
// By.cssSelector(".Order_ModalHeader__3FDaJ");