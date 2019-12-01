package io.github.itakahiro.databindingfootball.feature.football

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class FootballViewModel {
    private val _submittedText = MutableLiveData<String>().also { mutableLiveData ->
        mutableLiveData.value = "ここに、出力されます"
    }
    val submittedText: LiveData<String>
        get() = _submittedText

    private val _isEnabled: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().also { mutableLiveData ->
            mutableLiveData.value = false
        }
    val isEnabled: LiveData<Boolean>
        get() = _isEnabled

    private val _buttonText: MutableLiveData<String> =
        MutableLiveData<String>().also { mutableLiveData ->
            mutableLiveData.value = "Ready"
        }
    val buttonText: LiveData<String>
        get() = _buttonText


    fun updateButton(isBlank: Boolean) {
        _isEnabled.value = !isBlank

        if (!isBlank) {
            _buttonText.value = "Set!!!"
        } else {
            _buttonText.value = "Ready"
        }
    }

    fun submitText(text: String) {
        _submittedText.value = text
    }
}