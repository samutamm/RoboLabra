Viikkoraportti 2

Muokkasin toisella viikolla kolikoiden tunnistamiseen tarkoitettua mekaniikkaa ja ohjelmoin robotista ensimmäisen toimivan kokonaisuuden.  Robotille voi nyt manuaalisesti syöttää kolikoita, jotka robotti tunnistaa ja tallentaa (ajonaikaiseen) muistiin. Robotti erottaa kolikot toisistaan vain koon perusteella. 
En toteuttane suunnitelmassani ollutta väärien kolikoiden karsimista, sillä valosensori ei anna kolikoista tarpeeksi yksiselitteisiä arvoja tarkempaa validointia varten. Lisäksi tarvitsisin lisää mekaniikkaa liikuttamaan valosensoria erikokoisten kolikoiden pintaa vasten. Rakentelin tarvittavaa mekaniikkaa kolikoiden säilömistä varten; robotti tiputtaa kolikon oikean astian/pussin/rahasäilön kohdalla kolikon arvoa vastaavaan säilytyspaikkaan. Pyrin ensi viikolla viimeistelemään tämän.
Robotille pitää nyt syöttää kolikoita yksitellen n. 15-20 s välein. Rakentelen viimeisestä moottorista ja osista jonkinnäköisen annostelijan, jolle voi syöttää useamman kolikon kerralla, ettei robotin käyttö edellytä liikaa manuaalista työtä. 
Koodini on tällä hetkellä melko rumaa. Lähden seuraavaksi refaktoroimaan sitä selkeämmäksi ja ylläpidettävämmäksi. Onko olio-ohjelmointikielellä toteutetuille robottiohjelmille olemassa hyväksi todettuja arkkitehtuurimalleja? Tutkinen tätä myös viikolla kolme.
 
