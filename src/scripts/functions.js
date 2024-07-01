function getCurrentWeather(lat, lon){
    var apiKey = $jsapi.context().injector.weatherApiKey;
    var response = $http.get("http://api.openweathermap.org/data/2.5/weather?APPID=${APIkey}&units=${units}&lang=${lang}&lat=${lat}&lon=${lon}", {
        timeout: 10000,
        query:{
            APIkey: apiKey,
            units: "metric",
            lang: "ru",
            lat: lat,
            lon: lon
        }
    });
    if (!response.isOk || !response.data) {
        return false;
    }
    var weather = {};
    weather.temp = response.data.main.temp;
    weather.desc = response.data.weather[0].description;
    return weather;
}

function getOrderInfo(orderId){
    var xconnect = $jsapi.context().injector.xconnect;
    var xconnect_value = $jsapi.context().injector.xconnect_value;
    var response = $http.get("https://connect.travadm.org/api/jaicp/v1/customerorder/byid?order_id=${orderId}", {
        headers: {
            "X-CONNECT-TOKEN": "1ZvFPQ8AwivbOxF6GLus"
        },
        query: {
            orderId: orderId
        },
        timeout: 10000
    });
    if (!response.isOk || !response.data) {
        $reactions.answer(response.status);
        return false;
    }
    // var orderInfo = response.data;
    return response.data;
}