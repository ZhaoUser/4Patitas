import React from 'react';
import styles from './layout.module.css';

const Layout = ({ children }) => {
  return (
    <div className={styles.layoutContainer}>
      <header className={styles.header}>
        <h1>4Patitas</h1>
      </header>
      <main className={styles.mainContent}>{children}</main>
      <footer className={styles.footer}>
        <p>© 2024 4Patitas</p>
      </footer>
    </div>
  );
};

export default Layout;
