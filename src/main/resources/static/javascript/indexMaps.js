function initMap() {
	const options = {
		zoom : 11,
		center : {
			lat : 37.4221,
			lng : -122.0841
		}
	}

	const map = new google.maps.Map(document.getElementById('map'), options);

}

