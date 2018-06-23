package com.prateek.acni.tipcalculator.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry
import com.android.databinding.library.baseAdapters.BR

abstract class ObservableViewModel: ViewModel(),Observable {

    @delegate:Transient
    private val mCallback:PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallback.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
       mCallback.add(callback)
    }

    fun notifyChange(){
        mCallback.notifyChange(this, BR._all);
    }
}