// Аквариумное приложение - Фронтенд с использованием React
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link, Navigate, Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import './App.css';

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem('token');
    if (token) {
      setIsAuthenticated(true);
    }
  }, []);

  const handleLogout = () => {
    localStorage.removeItem('token');
    setIsAuthenticated(false);
  };

  return (
    <Router>
      <div className="App">
        <header className="app-header">
          {isAuthenticated && (
            <div className="header-buttons">
              <Link to="/profile" className="header-link">Профиль</Link>
              <Link to="/shop" className="header-link">Магазин</Link>
              <button onClick={handleLogout} className="header-link">Выйти</button>
            </div>
          )}
        </header>
        <Routes>
          <Route path="/" element={isAuthenticated ? <Navigate to="/aquarium" /> : <LoginPage setIsAuthenticated={setIsAuthenticated} />} />
          <Route path="/aquarium" element={isAuthenticated ? <AquariumPage /> : <Navigate to="/" />} />
          <Route path="/profile" element={isAuthenticated ? <ProfilePage /> : <Navigate to="/" />} />
          <Route path="/shop" element={isAuthenticated ? <ShopPage /> : <Navigate to="/" />} />
        </Routes>
      </div>
    </Router>
  );
}

function LoginPage({ setIsAuthenticated }) {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [email, setEmail] = useState('');
  const [isRegistering, setIsRegistering] = useState(false);

  const handleLogin = async () => {
    try {
      const response = await axios.post('/api/auth/login', { username, password });
      localStorage.setItem('token', response.data.token);
      setIsAuthenticated(true);
    } catch (error) {
      console.error('Ошибка авторизации:', error);
    }
  };

  const handleRegister = async () => {
    try {
      await axios.post('/api/auth/register', { username, password, email });
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

  return (
    <div className="login-container">
      <h2>{isRegistering ? 'Регистрация' : 'Авторизация'}</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Имя пользователя"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          required
        />
        {isRegistering && (
          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        )}
        <input
          type="password"
          placeholder="Пароль"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <button type="submit">{isRegistering ? 'Зарегистрироваться' : 'Войти'}</button>
      </form>
      <button onClick={() => setIsRegistering(!isRegistering)}>
        {isRegistering ? 'Уже есть аккаунт? Войти' : 'Нет аккаунта? Зарегистрироваться'}
      </button>
    </div>
  );
}

function AquariumPage() {
  const [fishes, setFishes] = useState([]);
  const [plants, setPlants] = useState([]);
  const [parameters, setParameters] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const fishResponse = await axios.get('/api/fish', {
        headers: { Authorization: `Bearer ${localStorage.getItem('token')}` }
      });
      setFishes(fishResponse.data);

      const plantResponse = await axios.get('/api/plants', {
        headers: { Authorization: `Bearer ${localStorage.getItem('token')}` }
      });
      setPlants(plantResponse.data);

      const parameterResponse = await axios.get('/api/aquarium_parameters', {
        headers: { Authorization: `Bearer ${localStorage.getItem('token')}` }
      });
      setParameters(parameterResponse.data);
    } catch (error) {
      console.error('Ошибка при загрузке данных:', error);
    }
  };

  return (
    <div className="aquarium">
      <h1>Аквариум</h1>
      <div className="aquarium-container">
        <h2>Рыбы</h2>
        <div className="fish-list">
          {fishes.map(fish => (
            <div key={fish.id} className="fish-item">
              <p>Имя: {fish.name}</p>
              <p>Вид: {fish.species}</p>
              <p>Размер: {fish.size} см</p>
              <p>Расположение: {fish.location}</p>
            </div>
          ))}
        </div>
      </div>

      <div className="aquarium-container">
        <h2>Растения</h2>
        <div className="plant-list">
          {plants.map(plant => (
            <div key={plant.id} className="plant-item">
              <p>Имя: {plant.name}</p>
              <p>Вид: {plant.species}</p>
              <p>Высота: {plant.height} см</p>
              <p>Расположение: {plant.location}</p>
            </div>
          ))}
        </div>
      </div>

      <div className="aquarium-container">
        <h2>Параметры аквариума</h2>
        <div className="parameter-list">
          {parameters.map(parameter => (
            <div key={parameter.id} className="parameter-item">
              <p>Параметр: {parameter.parameter_name}</p>
              <p>Значение: {parameter.value} {parameter.unit}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

function ProfilePage() {
  return (
    <div className="profile">
      <h2>Профиль пользователя</h2>
      <p>Информация о пользователе будет здесь.</p>
    </div>
  );
}

function ShopPage() {
  return (
    <div className="shop">
      <h2>Магазин</h2>
      <p>Товары для аквариума будут здесь.</p>
    </div>
  );
}

export default App;
