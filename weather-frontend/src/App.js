import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";

function App() {
  const [message, setMessage] = useState();
  const [location, setLocation] = useState(null);
  const [error, setError] = useState(null);

  // Fetch the data from the backend when the component is mounted
  useEffect(() => {
    fetch("http://localhost:8080/api/weather/message")
        .then((response) => response.text()) // Or response.json() if the backend returns JSON
        .then((data) => {
          setMessage(data); // Set the received data to the state
        })
        .catch((error) => {
          console.error("Error fetching data:", error);
        });

    // Get the user's location
    const getLocation = () => {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
            (position) => {
              const lat = position.coords.latitude;
              const lon = position.coords.longitude;
              setLocation({ lat, lon });
            },
            (err) => {
              setError('Unable to retrieve your location. Please check your browser settings.');
            }
        );
      } else {
        setError('Geolocation is not supported by this browser.');
      }
    };

    getLocation();
  }, []);
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <h1>Message from Backend:</h1>
        <p>{message}</p> {/* Display the fetched message */}
        {/* Display user's location */}
        {error && <p>{error}</p>} {/* Show error if there's an issue */}
        {location ? (
            <p>Your location: Latitude: {location.lat}, Longitude: {location.lon}</p>
        ) : (
            <p>Loading location...</p>
        )}
      </header>
    </div>
  );
}

export default App;
