import React from 'react';
import { useNavigate } from 'react-router-dom';
import { fakeOrganizations } from './data';
import styles from './home.module.css';

function Home() {
  const navigate = useNavigate();

  const handleAdotanteClick = () => {
    navigate('/cadastro-ado');
  };

  const handleOrganizacaoClick = () => {
    navigate('/cadastro-org');
  };

  const handleLoginClick = () => {
    navigate('/login');
  };

  return (
    <div className={styles.container}>
      <h1 className={styles.titulo}>Qual se enquadra com você?</h1>
      <div className={styles.buttonContainer}>
        <button className={styles.buttonHome} onClick={handleAdotanteClick}>
          Adotante
        </button>
        <button className={styles.buttonHome} onClick={handleOrganizacaoClick}>
          Organização
        </button>
        <button className={styles.buttonHome} onClick={handleLoginClick}>
          Login
        </button>
      </div>

      <h2 className={styles.subtitulo}>Lista de ONGs</h2>
      <ul className={styles.orgList}>
        {fakeOrganizations.map((org) => (
          <li key={org.id} className={styles.orgItem}>
            <h3>{org.name}</h3>
            <p>{org.description}</p>
            <p><strong>Localização:</strong> {org.location}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Home;