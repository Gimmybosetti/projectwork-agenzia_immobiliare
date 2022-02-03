function initMap() {
	const options = {
		zoom : 11,
		center : {
			lat : 45.464664,
			lng : 9.188540
		}
	}

	const map = new google.maps.Map(document.getElementById('map'), options);

}



