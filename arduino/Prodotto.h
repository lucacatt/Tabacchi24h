#ifndef Prodotto_h
#define Prodotto_h
class Prodotto
{
  private:
    String nomeProdotto;
    String PrezzoProdotto;
    bool Maggiorenne;
    String Scorte;

  public:
    Prodotto(String nome, String prezzo, bool mag, String sc)
    {
      this->nomeProdotto = nome;
      this->PrezzoProdotto = prezzo;
      this->Maggiorenne = mag;
      this->Scorte = sc;
    }
    String getNome();
    String getPrezzo();
    bool getMaggiorenne();
    String getScorte();
};
String Prodotto::getNome()
{
  return this->nomeProdotto;
}
String Prodotto::getPrezzo()
{
  return this->PrezzoProdotto;
}
bool Prodotto::getMaggiorenne()
{
  return this->Maggiorenne;
}
String Prodotto::getScorte()
{
  return this->Scorte;
}
#endif
