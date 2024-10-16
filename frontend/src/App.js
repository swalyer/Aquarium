// src/App.js
import React, { useContext } from 'react';
import { Navigate, Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import './App.css';
import Dashboard from './components/Dashboard';
import Login from './components/Login';
import MainPage from './components/MainPage';
import Register from './components/Register';
import { AuthContext } from './context/AuthContext';

function App() {
  const { auth } = useContext(AuthContext);

  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<MainPage />} />
          <Route 
            path="/login" 
            element={!auth.token ? <Login /> : <Navigate to="/dashboard" />} 
          />
          <Route 
            path="/register" 
            element={!auth.token ? <Register /> : <Navigate to="/dashboard" />} 
          />
          <Route 
            path="/dashboard" 
            element={auth.token ? <Dashboard /> : <Navigate to="/login" />} 
          />
          {          }
        </Routes>
      </div>
    </Router>
  );
}

export default App;
