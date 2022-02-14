#  CovidEmployeesApp
#### Serwis internetowy, z bazą danych pracowników.

## Spis treści
* [Specyfikacja wymagań](#specyfikacja-wymagań)
* [Stack Technologiczny](#stack-technologiczny)
* [Ilustracje](#ilustracje)


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

