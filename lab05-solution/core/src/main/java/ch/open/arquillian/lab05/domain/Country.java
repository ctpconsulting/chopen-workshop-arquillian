package ch.open.arquillian.lab05.domain;

public enum Country
{
   UNKNOWN,
   POLAND,
   BELGIUM,
   SCOTLAND,
   SWITZERLAND;


   public String getLabel()
   {
      return this.name().toLowerCase();
   }
}
