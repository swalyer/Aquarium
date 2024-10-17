import axios from 'axios';
import React, { useEffect, useState } from 'react';
import './AquariumPage.css';

function AquariumPage() {
  const [fishes, setFishes] = useState([]);
  const [plants, setPlants] = useState([]);
  const [parameters, setParameters] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const token = localStorage.getItem('token');
      const headers = { Authorization: `Bearer ${token}` };

      const fishResponse = await axios.get('/api/fish', { headers });
      setFishes(fishResponse.data);

      const plantResponse = await axios.get('/api/plants', { headers });
      setPlants(plantResponse.data);

      const parameterResponse = await axios.get('/api/aquarium_parameters', { headers });
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

export default AquariumPage;
