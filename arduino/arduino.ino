#include <LiquidCrystal.h>
#include "Prodotto.h"
#define btn1 13
#define btn2 10
#define btn3 9

Prodotto p[20] = Prodotto("", "", false, "");
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
String nome, prezzo, scorte, prod = "";
bool maggiorenne = false;
int cont = 0, count = 0;
int contMenu = 0;
bool b = false;

void setup()
{

  pinMode(btn1, INPUT);
  pinMode(btn2, INPUT);
  pinMode(btn3, INPUT);
  Serial.begin(19200);
  lcd.begin(16, 2);
  lcd.clear();
  Serial.setTimeout(100);
  nome = "";
  prezzo = "";
  scorte = "";
}

void loop()
{
  while (leggiProdotto())
    ;
  menu();
  delay(3000);
}

//--------------------------------------------------------------------------------------
bool leggiProdotto()
{
  Prodotto prodotto = Prodotto("", "", false, "");
  if (Serial.available() > 0)
  {
    prod = Serial.readString();
    for (int i = 0; i < prod.length(); i++)
    {
      if (prod.charAt(i) == '-')
      {
        count++;
        prod.remove(i, 1);
      }
    }
    int i = 0;
    int h = 0;

    while (h <= count)
    {
      //nome
      String c1 = "";
      while (prod.charAt(i) != ';')
      {
        c1 += prod.charAt(i);
        i++;
      }
      i++;
      //prezzo
      String c2 = "";
      while (prod.charAt(i) != ';')
      {
        c2 += prod.charAt(i);
        i++;
      }
      i++;
      delay(5000);
      //maggiorenne
      String c3 = "";
      while (prod.charAt(i) != ';')
      {
        c3 += prod.charAt(i);
        i++;
      }
      i++;
      //scorte
      String c4 = "";
      while (prod.charAt(i) != ';')
      {
        c4 += prod.charAt(i);
        i++;
      }
      if (c3 == "false")
      {
        maggiorenne = false;
      }
      else
      {
        maggiorenne = true;
      }
      prodotto = Prodotto(c1, c2, maggiorenne, c4);
      p[cont] = prodotto;
      cont++;
      if (cont > 1)
        lcd.print(p[1].getNome());
      h++;
    }
    return false;
  }
  return true;
}
//--------------------------------------------------------------------------------------
void acquisto()
{
  Serial.print("w");
  char t = ' ';
  while (t == ' ')
  {
    if (Serial.available() > 0)
    {
      t = Serial.read();
    }
  }
  if (t == '-')
  {
    if (p[contMenu].getMaggiorenne())
    {
      lcd.clear();
      lcd.print("ERRORE MINORENNE");
    }
    else
    {
      lcd.setCursor(0, 0);
      lcd.print("acquistato");
      lcd.setCursor(0, 1);
      lcd.print(p[contMenu].getNome());
      Serial.println(p[contMenu].getNome());
      delay(5000);
    }
  }
  else
  {
    lcd.setCursor(0, 0);
    lcd.print("acquistato");
    lcd.setCursor(0, 1);
    lcd.print(p[contMenu].getNome());
    Serial.println(p[contMenu].getNome());
    delay(5000);
  }
}
//--------------------------------------------------------------------------------------
void menu()
{
  while (true)
  {
    nome = p[1].getNome();
    prezzo = p[1].getPrezzo();
    lcd.setCursor(0, 0);
    lcd.print(nome);
    lcd.setCursor(0, 1);
    lcd.print(prezzo);
    while ((digitalRead(btn1) == LOW) && (digitalRead(btn3) == LOW))
      ;
    if (digitalRead(btn1) == HIGH)
    {
      if (contMenu < 1)
        contMenu = 0;
      else
        contMenu--;
    }
    else if (digitalRead(btn3) == HIGH)
    {
      if (contMenu > cont - 2)
        contMenu = cont - 1;
      else
        contMenu++;
    }
  }
  //acquisto();
}
//--------------------------------------------------------------------------------------
void serialFlush()
{
  while (Serial.available() > 0)
  {
    char t = Serial.read();
  }
}
