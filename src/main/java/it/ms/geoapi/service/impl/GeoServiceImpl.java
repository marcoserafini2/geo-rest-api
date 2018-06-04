package it.ms.geoapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import it.ms.geoapi.domain.Municipality;
import it.ms.geoapi.domain.repository.MunicipalityRepository;
import it.ms.geoapi.service.GeoService;

/**
 * Implementation {@link GeoService}
 *
 */
@Service
public class GeoServiceImpl implements GeoService {

	///////////////////////////////
	/////// REPOSITORIES //////////
	///////////////////////////////

	@Autowired
	MunicipalityRepository municipalityRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.ms.geoapi.service.GeoService#reverseGeoCoding(org.springframework.data.geo
	 * .Point)
	 */
	@Override
	public Municipality reverseGeoCoding(Point location) {
		return municipalityRepository.findByGeoIntersect(new GeoJsonPoint(location));
	}

}
