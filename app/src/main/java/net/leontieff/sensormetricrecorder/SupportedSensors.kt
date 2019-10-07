package net.leontieff.sensormetricrecorder

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class SupportedSensors : AppCompatActivity() {

    private lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supported_sensors)

        outputSupportedSensors()
    }

    fun outputSupportedSensors() {
        fun formatSupportedSensors(sensors: List<Sensor>): String {
            var output = "";
            sensors.forEach {
                output += "Found Sensor ${it.id} with name ${it.name} \n"
            }
            return output
        }

        var editTextHello = findViewById(R.id.supported_sensors) as EditText
        val supportedSensors = getSupportedSensors()

        editTextHello.setText(formatSupportedSensors(supportedSensors))
    }

    private fun getSupportedSensors(): List<Sensor> {
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
        return deviceSensors
    }
}
