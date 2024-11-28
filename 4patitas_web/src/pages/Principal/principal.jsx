import React from 'react';
import Layout from '/src/components/Layout/layout';
import Mapa from '/src/components/Mapa/mapa';
import Dog1 from '../../Img/dog.jpg';
import Cat2 from '../../Img/cat.jpg';
import Dog3 from '../../Img/dog3.jpg';
import Dog2 from '../../Img/dog2.jpg';
import styles from './principal.module.css';

const Principal = () => {
    return (
        <Layout>
            <section>
                <div className={styles.imageContainer}>
                  <img src={Dog1} alt="" className={styles.image}/>
                </div>
            </section>
            <section>
                <div className={styles.imageContainer}>
                  <img src={Dog2} alt="" className={styles.image}/>
                </div>
            </section>
            <section>
                <div className={styles.imageContainer}>
                  <img src={Dog3} alt="" className={styles.image}/>
                </div>
            </section>
            <section>
                <div className={styles.imageContainer}>
                  <img src={Cat2} alt="" className={styles.image}/>
                </div>
            </section>
        </Layout>
    );
};

export default Principal;