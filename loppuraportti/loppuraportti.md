













#Robottiohjelmoinnin harjoitustyö
*Kolikoiden lajittelijarobotti*
![alt tag](https://github.com/samutamm/RoboLabra/blob/master/images/kuva1.jpg)
Samu Tamminen
013976176
samutamm@cs.helsinki.fi





###Robotin kuvaus
Kolikoiden lajittelu robotti osaa lajitella sille syötettyjä eurokolikoita. Robotille syötetään käsin kolikoita yksi kerrallaan, robotti mittaa kolikon koon ja sen perusteella nakkaa kolikon oikeaan kasaan. Robotti myös laskee sille syötettyjen kolikoiden yhteisarvon ja kunkin kolikon määrän, joka näytetään robotin näytöllä robottia sammuttaessa. 
Joudun rajaamaan 10 sentin kolikot pois robotin toimialueelta, sillä pienen kokonsa takia ne sujahtavat mittauksessa käytetystä sulkuportista läpi. 
Robotti erottaa kolikot toisistaan pelkän koon perusteella, joten se tulkitsee esimerkiksi ravintolan WC-poletin yhden euron kolikoksi. Joillain syötteillä (varsinkin monista kolikoista koostuvilla) robotin mittausmekaniikka menee epätasapainoon ja robotti alkaa tulkita kolikoita virheellisesti. Asiasta lisää testitapausten esittelyssä.

###Robotin rakenne
Robotti koostuu kahdesta alustaan/rakenteeseen kiinnitetystä osasta; kolikoiden lajittelijasta ja kuljettajasta. Kolikoiden lajittelija mittaa moottorista ja valosensorista saatavan syötteen avulla kolikon halkaisijan. 
![alt tag](https://github.com/samutamm/RoboLabra/blob/master/images/kuva2.jpg)
Kolikko tiputetaan kouruun (kuvassa pystysuorassa kuvan keskikohdasta hieman oikealla),
jossa se valuu nojaamaan sulkuporttia vasten. Valosensori (kuvassa alhaalla, piuha lähtee oikealle) ottaa syötettä kourun mustasta seinämästä. Kun kolikko valuu sen eteen heijastamaan valoa takaisin mustaa taustaa enemmän, tietää robotti, että sillä on kolikko käsittelyssään. 
![alt tag](https://github.com/samutamm/RoboLabra/blob/master/images/kuva3.jpg)
Robotin kolikon mittaaja avaa moottorillaan sulkuporttia, jota vasten kolikko nojaa. Kun portti on auennut tarpeeksi, kolikko tipahtaa portin läpi ja valosensorin syötteestä robotti tietää kolikon jatkaneen matkaa. Robotti on tallentanut sulkuportin aukeamista muuttujaan ja tämän muuttujan arvo kertoo kolikon koon suhteessa toisiin kolikoihin. Sulkuporttia suljetaan saman verran, kuin sitä avattiin (tässä tulee epäkalibroitumista) ja kolikon arvo haetaan kovakoodatusta hakurakenteesta sen koon perusteella.
![alt tag](https://github.com/samutamm/RoboLabra/blob/master/images/kuva4.jpg)
Kun kolikko on mitattu ja tunnistettu kolikoiden lajittelijalla, tippuu kolikko kuljettajan kouraan. Lajitelijan koura kääntyy moottorinsa avulla oikean kolikkokasan kohdalle ja heittaa kolikon kasaan. Kasat on erotettu toisistaan pahvilla, mika on melko rumaa, mutta soveltunee harjoitustyölle.
![alt tag](https://github.com/samutamm/RoboLabra/blob/master/images/kuva5.jpg)
Tämän jälkeen voidaan syöttää uusi kolikko tai lopettaa ajo painamalla Escape-nappia. Kun lopulta painetaan Escape, näyttää robotti vielä näytöllään kolikoiden määrät.












###Koodin rakenne
Koodi koostuu neljästä pakkauksesta: robo/main, robo/domain, robo/controllers ja robo/Calculator. Controllers ja Calculator sisältävät molemmat vain yhdet luokat. Luokan robo/controllers/MotorController.java:n tehtävä on paketoida LejOS:n staattisten luokkien NXTRegulatedMotor ilmentymiä A, B ja C niin, ettei ohjelmakoodissa niihin viitatessa tarvitse toistaa kirjainta. Luokka robo/Calculator/Calculator.java tallentaa syötetyt kolikot ajonaikaiseen tietorakenteeseen ja palauttaa pyydettäessä.

Pakkauksessa robo/domain on robotin toiminnallisuuden kannalta keskeiset neljä luokkaa. Luokka Coin.java muistaa yhteen kolikkoon liittyvät arvot ja luokassa Coins.java luodaan kolikot ja asetetaan(/kovakoodataan) kolikoiden koko, arvo ja kolikkokasan sijainti. Coins-luokasta voi hakea ajassa O(log n) tiettyä sulkuportin arvoa vastaavan Coin-olion, joskin tällä hetkellä kolikoita on vain kahdeksan eli tehokkuudesta ei ole suurta etua.

Luokka robo/domain/Sorter.java hallinnoi robotin kolikon lajittelijaan (kts. robotin rakenne) liittyvää toiminnallisuutta. Metodi getStartLightValue mittaa valosensorin arvoja mustaa taustaa vasten ja palauttaa arvon, johon kolikoista mitattuja arvoja verrataan. Metodi openPortUntilCoinFlops avaa porttia, kunnes kolikko tippuu, hakee Coins-oliolta kolikon kokoa vastaavan Coin olion ja palauttaa sen sitä kutsuvalle Robot-oliolle.
Luokalla robo/domain/Convoyer.java on metodi moveCoin, joka liikuttaa robotin kuljettajan käsivartta parametrinaan saadun asteluvun verran ja heittää kolikon oikeaan kolikko kasaan.

Pakkauksessa robo/main on pääluokka main, joka luo Robot-olion ja kutsuu sen metodia run. Robot-olio luo konstruktorissaan luokista Sorter, Convoyer ja Calculator ilmentymät. Run metodia ajettaessa käyttäjää pyydetään asettamaan ensimmäinen kolikko ja painamaan nappia. Tämän jälkeen käynnistyy looppi, joka jatkuu, kunnes painetaan ESCAPE-nappia. Loopin sisällä pyydetään Sorter-oliolta mittaamaan kolikko, tallennetaan saatu kolikko Calculator-oliolle, tulostetaan tämän hetkinen rahatilanne ja jäädään odottamaan uutta kolikkoa tai ohjelman lopetusta(escape). Loopin päätyttyä tulostetaan kolikoista tilastot.

###Testaus
Testaan, tunnistaako robotti kolikot oikein ja heittääkö se ne oikeisiin pinoihin. Rajaan 10 sentin kolikot testien ulkopuolelle, sillä pienen kokonsa takia ne livahtavat sulkuportista suoraan läpi. 

#####Testitapaus 1
Annan robotille kaikki kolikot kertaalleen kolmessa eri järjestyksessä((2, 0.5, 1, 0.2, 0.05) (0.05, 0.2, 1, 0.5, 2) (1, 2, 0.05, 0.5, 0.2)).

Robotti tunnisti oikein kaikki kolikot ja heitti oikeisiin kasoihin.

#####Testitapaus 2
Annan robotille kolikot samassa järjestyksessä kuin ensimmäisessä testissä, mutta syötän jokaisen kolikon kaksi kertaa peräjälkeen.

Kahden euron kolikko jäi kerran jumiin kuljettajan kouraan, mutta muuten robotti toimi moitteetta.

#####Testitapaus 3
Syötän kunkin kolikon robotille viisi kertaa putkeen.

Robotti erehtyy heti alkuun tulkitessaan 20 senttisen 5 senttiseksi. Robotin sulkuportti oli jäänyt kahden edellisen testin (n. 50 kolikon) jäljiltä hieman liikaa auki. Kalibroin sulkuportin käsin silmämääräisesti ja robotin tunnistus pelasi moitteetta testin loppuun. 2 euron ja 20 sentin kolikko tippuivat molemmat yhden kerran kuljettajan kourasta.

###Rajoitukset ja tulevaisuus
Testeissä robotti tulkitsi 20 sentin kolikon 5 senttiseksi. Tämä voitaisi välttää tarkemmalla kalibroinnilla; robotin sulkuportin tulisi sulkeutua aina saman verran, kuin se aukeni. Kuitenkin sulkuporttia avataan aluksi pienissä osissa, jolloin moottori saattaa liikkua enemmän, kuin yhdellä moottorin liikutuksella. On siis vaikea arvioida, kuinka paljon enemmän sulkuporttia tulisi sulkea, että se palautuisi alkuperäiseen tilaansa. Robotin toteutuksessa päädyin ratkaisuun, jossa porttia suljetaan jokaiselle kolikolle määritellyn asteluvun verran. 	Paras tulos saataisiin varmaan pienen sensorin avulla, joka osaisi kertoa moottorille, kun ollaan palattu alkutilanteeseen. Näin robotti voisi itse kalibroida itsensä.

Kahden euron ja 20 sentin kolikot tippuivat välillä kuljettajan kourasta. Kourasta saisi varmemman suunnittelemalla ja toteuttamalla kaikille kolikoille sopivan muotoinen koura. Koura voisi ottaa kolikosta vielä kiinni pihdeillä.

Robotille pitää syöttää kolikoita manuaalisesti yksitellen, mikä on tylsää ja tehotonta. Aioin alunperin toteuttaa jonkinnäköisen annostelijan, joka antaisi lajittelijalle kolikoita jonosta. Ajanpuutteen ja teknisten vaikeuksien takia jätin annostelijan tekemättä. Annostelijan avulla robotista voisi tulla hyödyllinen työkalu: robotille voisi syöttää suuren kasan kolikoita ja antaa sen lajitella kaikessa rauhassa. 

###Käyttöohje:
1. Käynnistä robotti NXT-brickin oranssista Enter-napista. 
2. Robotti kysyy “Is coin ready?” Aseta ensimmäinen kolikko kouruun punaisen valon kohdalle ja paina uudelleen Enter-nappia.
3. Robotti mittaa kolikon ja heittää oikeaan paikkaan. Voit joko pysäyttää ohjelman Enter-napin alapuolella olevasta Escape-napista tai voi syöttää uuden kolikon.
4. Kun ohjelma pysäytetään, näytöllä näytetään kolikot.

