package it.ms.geoapi.domain.repository;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import it.ms.geoapi.domain.Municipality;

/**
 * Repository of {@link Municipality}
 *
 */
@Repository
public interface MunicipalityRepository extends MongoRepository<Municipality, String> {

	@Query(value = "{ 'geometry' : { '$geoIntersects' : { $geometry: ?0 } } }")
	Municipality findByGeoIntersect(GeoJsonPoint geoJsonPoint);
}
