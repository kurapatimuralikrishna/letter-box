import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import HomePage from './components/HomePage';
import ShowMovies from './components/movieComponents/ShowMovies';

function App() {
  return (
    <div>
      <Header />
      <Router>
        <div className="container">
          <div className="container">
            <Routes> 
            <Route exact path= "/" element = {<HomePage />} />
              <Route exact path= "/home" element = {<HomePage />} />
              <Route exact path= "/movies" element = {<ShowMovies />} />
              <Route exact path= "/movies/search" element = {<HomePage />} />
              <Route exact path= "/movies/search" element = {<HomePage />} />
              <Route exact path= "/members" element = {<HomePage />} />
              <Route exact path= "/about" element = {<HomePage />} />
            </Routes>
          </div>
        </div>
      </Router>
    </div>
  );
  }

export default App;
