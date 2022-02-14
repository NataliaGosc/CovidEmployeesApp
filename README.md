# AnimalChip
#### Serwis internetowy, w którym rejestrowane chipy zwierząt domowych.

## Spis treści 
* [Wprowadzenie](#wprowadzenie)
* [Specyfikacja wymagań](#specyfikacja-wymagań)
* [Stack Technologiczny](#stack-technologiczny)
* [Ilustracje](#ilustracje)

## Wprowadzenie 
 
Wiele ze zwierząt, które się zgubią, nigdy nie wraca do domu. W przypadku gdy doszło do kradzieży
zwierzęcia mogłoby być trudno udowodnić, że dane zwierzę jest naszym . Mimo, iż prężnie
funkcjonujące grupy w social mediach pomagają w odnalezieniu właściciela, nie zawsze udaje się
aby znaleziony zwierzak trafił z powrotem do swojego domu. Właściwa rejestracja sprawia, że można
temu zapobiec. Celem projektu było stworzenie serwisu internetowego, w którym rejestrowane są
zwierzęta domowe takie jak psy i koty. Niezalogowany użytkownik odwiedzjący stronę internetowa
może sprawdzić, czy podany chip znajduje się w bazie danych, natomiast zalogowany użytkownik,
może uzyskać informację na temat odnalezionego zwierzęcia, lub zarejestrować swoje zwierzęta.
Dodatkowa rola Administratora systemu umożliwia zarzadzanie wszystkim zwierzętami znajdującymi
się w bazie danych. 


## Specyfikacja wymagań
## Stack technologiczny
<ol>
<li> Architektura serwisu internetowego AnimalChip została przygotowana z wykorzystaniem
ASP .NET CORE 5 z zastosowaniem wzorca projektowego MVC.</li>
<li>Użytkownicy mają możliwość zalogowania się do serwisu z pomocą Facebooka, dzięki
wykorzystaniu otwartego standardu do autoryzacji OAuth 2.0. </li>
<li>Do dynamicznego wyszukiwania została zastosowana biblioteka JQuery. </li>
<li> Serwis stawia na rozbudowane bezpieczeństwo każdy formularz jest odpowiednio
walidowany cyberprzestępca nie ma możliwości przeprowadzić ataku XSS oraz SQL
Injection.</li>
<li> Strona jest udostępniona w czterech językach (polskim, angielskim, francuskim, hiszpańskim)
w modelu została wykorzystana wbudowana usługa globalizacji ASP .NET CORE.</li>
<li>Do ładowania bazy danych na stronie został zaimplementowany serwis AddMemoryCache()
z przekazaniem listy do zmiennej, aby skrócić czas odświeżania/ładowania strony. </li>
<li> Potwierdzenie konta użytkownika odbywa się poprzez skorzystanie przez niego z linka,
wysłanego na email, przy użyciu którego dokonał rejestracji</li>
<li>REST web api zostało zaimplementowane w postaci interfejsu Swagger oraz przy użyciu API
Kontrolera (testownego w Postmanie)</li>
<li>Własny Routing</li>
<li>Błędy zostały obsłużone blokami try/catch, natomiast formularze walidacją za pomocą
adnotacji.</li>
</ol>


## Ilustracje

![1](https://user-images.githubusercontent.com/83544756/153937353-a1590cdb-db67-49e9-ab26-e54d88c2600d.png)
![5](https://user-images.githubusercontent.com/83544756/153937363-d38c009c-2f53-499e-97e8-d9f3b9b96b3e.png)
![3](https://user-images.githubusercontent.com/83544756/153937369-6ea91aa6-ccae-42e2-8c8a-7c48c380accb.png)
![4](https://user-images.githubusercontent.com/83544756/153937377-aaa9f930-5bc7-475e-8a5d-0b86f4f4921d.png)
![6](https://user-images.githubusercontent.com/83544756/153937385-6a319842-273d-4200-a1ea-7a2b3da90ed7.png)
![8](https://user-images.githubusercontent.com/83544756/153937391-97c1ba42-93d9-447d-8ae6-279e2704b72f.png)
