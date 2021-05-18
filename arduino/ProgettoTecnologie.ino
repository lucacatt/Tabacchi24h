
#include <LiquidCrystal.h>
#include "Prodotto.h"
#define btn1 13
#define btn2 10
#define btn3 9

Prodotto p[20] = Prodotto("", "", false, "");
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
String nome, prezzo, scorte, prod = "";
bool maggiorenne = false;
int cont = 0;
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
  while (leggiProdotto());
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
    int i = 0;
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
    return true;
  }
  return false;
}
//--------------------------------------------------------------------------------------

