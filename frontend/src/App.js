import React, { useEffect, useState } from 'react';
import { Navigate, Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import AquariumPage from './AquariumPage';
import LoginPage from './LoginPage';

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem('token');
    if (token) {
      setIsAuthenticated(true);
    }
  }, []);

  return (
    <Router>
      <Routes>
        <Route path="/" element={isAuthenticated ? <Navigate to="/aquarium" /> : <LoginPage setIsAuthenticated={setIsAuthenticated} />} />
        <Route path="/aquarium" element={isAuthenticated ? <AquariumPage /> : <Navigate to="/" />} />
      </Routes>
    </Router>
  );
}

export default App;
