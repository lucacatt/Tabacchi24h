#include <LiquidCrystal.h>
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
#define rosso 6
#define blu 7
#define verde 8
#define btn1 13
#define btn2 10
#define btn3 9

void setup() {
  lcd.begin(16, 2);
  lcd.clear();
  pinMode(rosso,OUTPUT);
  pinMode(blu,OUTPUT);
  pinMode(verde,OUTPUT);
  pinMode(btn1,INPUT);
  pinMode(btn2,INPUT);
  pinMode(btn3,INPUT);
  Serial.begin(9600);
}

int eta = 0;
bool nuovoOrdine=false;

void loop() {
  menu();
  digitalWrite(rosso,HIGH);
  if(!nuovoOrdine){
 	 while(!lettura());
  }
  ordina();
  continua();
}
void menu(){
  lcd.print("1-Camel ");
  lcd.print("2-Fanta");
  lcd.setCursor(0,2);
  lcd.print("3-Gratta e vinci");
}
void controllo(String prodotto){
  Serial.print(prodotto);
  while(Serial.readString()!="f");
  delay(1000);
  lcd.print("Comprato");
}
bool lettura(){
  if(Serial.readString()=="+"){
    eta = 18;
    return true;
  }
  else if(Serial.readString()=="-")
  {
     eta = 17;
     return true;
  }
   return false;
}
void ordina(){
  while(digitalRead(btn1)==LOW&&digitalRead(btn2)==LOW&&digitalRead(btn3)==LOW);
  if(digitalRead(btn1)==HIGH)
     {
     	lcd.clear();
    	if(eta==18){
     		lcd.print("elaborazione1...");
     		controllo("sigarette");
    	}
    	else{
     		lcd.print("no minorenne");
    	}
     }
  else if(digitalRead(btn2)==HIGH)
     {
     	lcd.clear();
     	lcd.print("elaborazione2...");
   	 	controllo("fanta");
     }
  else if(digitalRead(btn3)==HIGH)
     {
     	lcd.clear();
        if(eta==18){
     		lcd.print("elaborazione3...");
    		controllo("gratta");
   		}
   		else{
     		 lcd.print("no minorenne");
    	}
     }
 }
void continua(){
  lcd.clear();
  lcd.print("Continuare?");
  lcd.setCursor(0,2);
  lcd.print("1-si 2-no");
  while(digitalRead(btn1)==LOW&&digitalRead(btn2)==LOW);
  if(digitalRead(btn1)==HIGH)
    nuovoOrdine=true;
  else
    nuovoOrdine=false;
}
 