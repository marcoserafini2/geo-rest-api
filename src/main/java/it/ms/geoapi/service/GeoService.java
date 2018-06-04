package it.ms.geoapi.service;

import org.springframework.data.geo.Point;

import it.ms.geoapi.domain.Municipality;

/**
 * Service
 */
public interface GeoService {

	/**
	 * Get Municipality from a point
	 * 
	 * @param location 
	 * @return 
	 */
	Municipality reverseGeoCoding(Point location);

}
