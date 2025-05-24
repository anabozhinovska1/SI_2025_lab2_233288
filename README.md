# SI_2025_lab2_233288
# Ana Bozinovska 233288
![CFD-233288](https://github.com/user-attachments/assets/b2234956-6047-46b6-b0fe-098ef3ec0e19)



## Цикломатска комлексност
Број на ребра - број на јазли +2
33-26+2 = 9

## За да се изврши Every Statment критериум потребно е минимум 5 тест случаи

  allItems = null
  cardNumber = "1234"	
  Фрла exception: "allItems list can't be null!"
  
  allItems = [Item(null, 1, 100, 0)]
  cardNumber = "1111222233334444"	
  Фрла exception: "Invalid item!"

  allItems = [Item("banana", 1, 100, 0)]
  cardNumber = "123ABC"	
  Фрла exception: "Invalid card number!"

  allItems = [Item("banana", 1, 100, 0)]
  cardNumber = "1111222233334444"	
  Враќа: 100.0

  allItems = [Item("milk", 2, 400, 0.25)]
  cardNumber = "1111222233334444"
  Враќа: 570.0

  ## Multiple condition Testing
  За if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10) вкупниот број на тест случаи е 2^3=8
  
      A=false, B=false, C=false
      Item a = new Item("A", 5, 100, 0);
      assertEquals(100*5, SILab2.checkCart(List.of(a), validCard));

      A=true
      Item b = new Item("B", 5, 400, 0);
      assertEquals(400*5 - 30, SILab2.checkCart(List.of(b), validCard));

      B=true
      Item c = new Item("C", 5, 100, 0.1);
      assertEquals(100*0.9*5 - 30, SILab2.checkCart(List.of(c), validCard));

      C=true
      Item d = new Item("D", 20, 100, 0);
      assertEquals(100*20 - 30, SILab2.checkCart(List.of(d), validCard));

      A + B + C = true
      Item e = new Item("E", 20, 400, 0.5);
      assertEquals(400*0.5*20 - 30, SILab2.checkCart(List.of(e), validCard));
  

 
