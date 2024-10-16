// src/components/MainPage.js
import React from 'react';
import { Link } from 'react-router-dom';
import './MainPage.css';

function MainPage() {
  return (
    <div className="main-page">
      <h1>Добро пожаловать к Рыбовам</h1>
      <div className="button-group">
        <Link to="/login" className="btn">Войти</Link>
        <Link to="/register" className="btn">Зарегистрироваться</Link>
      </div>
    </div>
  );
}

export default MainPage;
