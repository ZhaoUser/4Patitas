import React from 'react';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import 'leaflet/dist/leaflet.css';
import styles from './mapa.module.css';

function Mapa() {
  return (
    <div className={styles.mapPage}>
      <h1>4 PATITAS</h1>
      <MapContainer
        center={[51.505, -0.09]}
        zoom={12}
        style={{ height: '50vh', width: '200%', borderRadius: '10px', overflow: 'hidden' }}
        aria-label="Mapa interativo de exemplo"
      >
        <TileLayer
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        />
        <Marker position={[51.505, -0.09]}>
          <Popup>
            Corinthians
          </Popup>
        </Marker>
      </MapContainer>
    </div>
  );
}

export default Mapa;
