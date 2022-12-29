package demo;

class HelloWorld {
    public static void main(String[] args) {
    	String FESTSTELLUNG_SELECT_QUERY = "SELECT "
    			+ "	 aufgabe.id                                      AS aufgabeId,\r\n"
    			+ "  aufgabe.bearbeiterid                            AS bId,\r\n"
    			+ "  aufgabe.status                                  AS status,\r\n"
    			+ "  person.familienname                             AS familienname,\r\n"
    			+ "  person.vornamen                                 AS vorname,\r\n"
    			+ "  postfach_klaerungsfall.klaerungsfallkennzeichen AS klaerungsfallkennzeichen,\r\n"
    			+ "  postfach_klaerungsfall.vbm						 AS vbm,\r\n"
    			+ "  postfach_klaerungsfall.betroffene_personenid    AS ausloserPersonId,\r\n"
    			+ "  ereignis.ereigniszeitpunkt					     AS ereigniszeitpunkt,\r\n"
    			+ "  pflege.pflegende_stelle_id						 AS pflegendeStelle\r\n"
    			+ " FROM POSTFACH_AUFGABE aufgabe\r\n" + " LEFT JOIN POSTFACH_KLAERUNGSFALL postfach_klaerungsfall\r\n"
    			+ " ON aufgabe.id = postfach_klaerungsfall.fk_aufgabe\r\n"
    			+ " LEFT JOIN IDNR_IDENTIFIKATION identifikation\r\n"
    			+ " ON aufgabe.personenid = identifikation.personenid\r\n" + " LEFT JOIN IDNR_PERSON person\r\n"
    			+ " ON identifikation.fk_person = person.id\r\n" + " LEFT JOIN IDNR_EREIGNIS ereignis\r\n"
    			+ " ON identifikation.id=ereignis.fk_identifikation\r\n" + " LEFT JOIN IDNR_PFLEGE pflege\r\n"
    			+ " ON identifikation.fk_person=pflege.fk_person\r\n" + " WHERE ereignis.versionsnr=1 "
    			+ " AND aufgabe.id in ( %s ) \r\n";
    	System.out.println(FESTSTELLUNG_SELECT_QUERY);
    	System.out.println("----------------------------------------------------");
    	String FESTSTELLUNG_NESTED_SELECT_QUERY = " "
    			+ " select aufgabe.id from POSTFACH_AUFGABE aufgabe\r\n" + " WHERE aufgabe.typ= :aufgabeType\r\n "
    			+ "	AND (aufgabe.bearbeiterid IS NULL" + " OR aufgabe.bearbeiterid IN (:bearbeiterId))\r\n "
    			+ "	AND aufgabe.status IN (:aufgabeStatus)\r\n" + "	ORDER BY sys_extract_utc(aufgabe.anlagezeitpunkt)\r\n"
    			+ "	FETCH FIRST 1000 ROWS ONLY ";
System.out.println(FESTSTELLUNG_NESTED_SELECT_QUERY);
        System.out.println("Hello, World!");
        HelloWorld hw=new HelloWorld();
        Integer s=10;
       demos d= new demos(10,20);
       System.out.println(d.a);
       System.out.println(d.b);
       String x="shiva";
       System.out.println(x);
       hw.abc(x,d);
       System.out.println(d.a);
       System.out.println(d.b);
       System.out.println(x);
    }
    
    public String abc(String x,demos d)
    {
       demos d2=d;
       demos w=new demos(20,30);
       w=d2;
       w.a=400;
       String y=x;
       d2.b=300;
       d2.a=500;
       System.out.println(w.a);
      y =x+'a';
        return x;
    }
    

}