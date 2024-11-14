// src/App.js

import React from 'react';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import AquariumPage from './components/AquariumPage';
import LoginPage from './components/LoginPage';
import RegisterPage from './components/RegisterPage';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/login" element={<LoginPage />} />
                <Route path="/register" element={<RegisterPage />} />
                <Route path="/" element={<AquariumPage />} />
                {/* Добавьте другие маршруты  */}
            </Routes>
        </Router>
    );
}

export default App;

