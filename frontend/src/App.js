import React from 'react';
import Header from './components/Header';
import SearchBar from './components/SearchBar';
import Dropdown from './components/Dropdown';
import ResultsList from './components/ResultsList';
import DetailedView from './components/DetailedView';
import './App.css';

function App() {
    return (
        <div className="App">
            <Header />
            <div className="content">
                <div className="controls">
                    <div className="intro-text">
                        <p>
                            Lasse dir die Trend Nachrichten aus aller Welt anzeigen!
                        </p>
                        <p>
                            Anleitung: Benutze eine der Möglichkeiten um die Nachrichten deiner Wahl anzeigen zu lassen.
                            Beispiel: Du willst die Top Nachrichten aus Deutschland wissen dann wähle Deutschland aus und klicke auf GO!.
                            Anschließend kannst du auf der rechten Seite zwischen 5 Themen auswählen und dich durchlesen.
                        </p>
                    </div>
                    <Dropdown label="Wähle ein Land aus" />
                    <SearchBar placeholder="Suche nach was bestimmten" />
                    <Dropdown label="Wähle ein Thema aus" />
                </div>
                <div className="results">
                    <ResultsList />
                    <DetailedView />
                </div>
            </div>
        </div>
    );
}

export default App;
