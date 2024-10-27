import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './LoginPage.css';

function LoginPage({ setIsAuthenticated }) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [isRegistering, setIsRegistering] = useState(false);
  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const response = await axios.post('http://localhost:8080/api/login', { email, password });
      localStorage.setItem('token', response.data.token);
      setIsAuthenticated(true);
      navigate('/aquarium');
    } catch (error) {
      console.error('Ошибка авторизации:', error);
    }
  };

  const handleRegister = async () => {
    try {
      await axios.post('http://localhost:8080/api/register', { email, password });
      handleLogin();
    } catch (error) {
      console.error('Ошибка регистрации:', error);
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (isRegistering) {
      handleRegister();
    } else {
      handleLogin();
    }
  };

  const isFormValid = () => {
    return email && password.length >= 6;
  };

  return (
    <div className="login-container">
      <div className="aquarium">
        <div className="fish fish1"></div>
        <div className="fish fish2"></div>
        <div className="fish fish3"></div>
      </div>
      <div className="login-form">
        <h2>{isRegistering ? 'Регистрация' : 'Авторизация'}</h2>
        <form onSubmit={handleSubmit}>
          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          <input
            type="password"
            placeholder="Пароль"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          <button type="submit" disabled={!isFormValid()}>
            {isRegistering ? 'Зарегистрироваться' : 'Войти'}
          </button>
        </form>
        <button className="toggle-button" onClick={() => setIsRegistering(!isRegistering)}>
          {isRegistering ? 'Уже есть аккаунт? Войти' : 'Нет аккаунта? Зарегистрироваться'}
        </button>
      </div>
    </div>
  );
}

export default LoginPage;
