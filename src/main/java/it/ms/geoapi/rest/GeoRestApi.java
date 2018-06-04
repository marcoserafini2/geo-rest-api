package it.ms.geoapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.ms.geoapi.domain.Municipality;
import it.ms.geoapi.service.GeoService;

/**
 * RESTful API endpoints using Spring MVC
 */
@RestController
@RequestMapping(
		value = "/api/v1/",
		produces = MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE)
public class GeoRestApi {

	///////////////////////////////
	////////// SERVICES ///////////
	///////////////////////////////

	@Autowired
	GeoService geoService;

	////////////////////////////////
	////////// API METHOD //////////
	////////////////////////////////

	@PostMapping(value = "geocode")
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Municipality reverseGeoCoding(@RequestBody Point location) {
		return geoService.reverseGeoCoding(location);
	}

}