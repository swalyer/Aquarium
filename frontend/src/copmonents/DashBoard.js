// src/components/Dashboard.js
import React, { useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';
import './Dashboard.css';

function Dashboard() {
  const { auth, logout } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate('/');
  };

  if (!auth.token) {
    navigate('/login');
    return null;
  }

  return (
    <div className="dashboard">
      <h2>Добро пожаловать, {auth.user ? auth.user.username : 'Пользователь'}!</h2>
      <button onClick={handleLogout}>Выйти</button>
      {               }
    </div>
  );
}

export default Dashboard;
