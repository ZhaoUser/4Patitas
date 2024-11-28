import React, { useState } from 'react';
import styles from './navegar.module.css';

function Navegar() {
  const [isOpen, setIsOpen] = useState(false);

  const toggleSidebar = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div>
      <div className={`${styles.sidebar} ${isOpen ? styles.open : ''}`}>
        <button className={styles.closeBtn} onClick={toggleSidebar}>
          &times;
        </button>
        <h1>Sidebar</h1>
        {/* Adicione os itens de navegação aqui */}
      </div>
      <button className={styles.openBtn} onClick={toggleSidebar}>
        {isOpen ? 'Close' : 'Open'} Sidebar
      </button>
    </div>
  );
}

export default Navegar;
