// src/components/AquariumPage.js

import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { FaCog, FaUserCircle } from 'react-icons/fa';
import './AquariumPage.css';

const AquariumPage = () => {
    const [fish, setFish] = useState([]);
    const [plants, setPlants] = useState([]);

    useEffect(() => {
        // Функция для получения данных о рыбах
        const fetchFish = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/fish');
                setFish(response.data);
            } catch (error) {
                console.error('Ошибка при получении рыб:', error);
            }
        };

        // Функция для получения данных о растениях
        const fetchPlants = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/plants');
                setPlants(response.data);
            } catch (error) {
                console.error('Ошибка при получении растений:', error);
            }
        };

        fetchFish();
        fetchPlants();
    }, []);

    return (
        <div className="aquarium-container">
            {/* Верхние кнопки */}
            <div className="top-buttons">
                <button className="profile-button">
                    <FaUserCircle size={30} />
                </button>
                <div className="settings-button-container">
                    <button className="settings-button">
                        <FaCog size={30} />
                    </button>
                    <span className="settings-tooltip">Настройки</span>
                </div>
            </div>

            {/* Визуализация аквариума */}
            <div className="aquarium">
                {/* Растения */}
                {plants.map((plant) => (
                    <img
                        key={plant.id}
                        src={plant.imageUrl}
                        alt={plant.name}
                        className={`plant plant-${plant.position}`}
                    />
                ))}

                {/* Рыбы */}
                {fish.map((fishItem) => (
                    <img
                        key={fishItem.id}
                        src={fishItem.imageUrl}
                        alt={fishItem.name}
                        className={`fish fish-${fishItem.position}`}
                    />
                ))}

                {/* Фон аквариума */}
                <img
                    src="/images/aquarium-background.png"//
                    alt="Aquarium Background"
                    className="aquarium-background"
                />
            </div>
        </div>
    );
};

export default AquariumPage;
