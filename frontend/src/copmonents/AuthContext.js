// src/context/AuthContext.js
import React, { createContext, useState } from 'react';

// Создаем контекст
export const AuthContext = createContext();

// Провайдер контекста
export const AuthProvider = ({ children }) => {
  const [auth, setAuth] = useState({
    token: localStorage.getItem('token'),
    user: null,
  });

  // Функция для сохранения токена
  const login = (token, user) => {
    localStorage.setItem('token', token);
    setAuth({ token, user });
  };

  // Функция для выхода
  const logout = () => {
    localStorage.removeItem('token');
    setAuth({ token: null, user: null });
  };

  // Здесь можно добавить функцию для получения данных пользователя по токену

  return (
    <AuthContext.Provider value={{ auth, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};
