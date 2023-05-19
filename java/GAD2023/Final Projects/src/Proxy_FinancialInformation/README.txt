Proxy Design Pattern:
Baza de date a unei banci contine informatii inportante care ar trebui
sa fie accesibile doar de catre anumite persoane. Practic asta face proxy-ul,
care este un middleman intre persoana care vrea sa acceseze datele si banca.
Pentru a accesa datele, mai intai trece pe la proxy care verifica accesul persoanei
la informatii si ii permite sau nu accesul.
In exemplul create de mine, este permisa accesarea datelor doar daca persoana
care incearca sa se "logheze" are usernamul "admin" si parola "password".