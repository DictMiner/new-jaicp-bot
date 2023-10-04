theme: /Weather

    state: Current
        # intent!: /geo
        script:
            $temp.currentWeather = getCurrentWeather($session.arrivalCity.lat, $session.arrivalCity.lon);
        if: $temp.currentWeather
            a: В городе {{ capitalize($nlp.inflect($session.arrivalCity.name, "loct")) }} сейчас {{ $temp.currentWeather.desc }}, {{ Math.round($temp.currentWeather.temp) }}*C }}
        else:
            a: Погоду по региону не найдена
