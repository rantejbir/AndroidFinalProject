package com.cst2335.androidfinalproject.data;


/**
 * Author: Daksh Sharma
 * Date updated: 8/4/2023
 * purpose:The outcome of an operation, which may succeed or fail with an error, is represented by this generic
 * class, named resultModel.
 * This class serves as a type-safe and user-friendly means of handling success and error scenarios in code.
 */
public class resultModel <T> {
    // hide the private constructor to limit subclass types (Success, Error)

    @Override
    public String toString() {

        if
        (this instanceof resultModel.Success) {
            resultModel.Success success = (resultModel.Success) this;
            return "Success[data=" + success.getData().toString() + "]";
        } else if (this instanceof resultModel.Error) {
            resultModel.Error error = (resultModel.Error) this;
            return "Error[exception=" + error.getError().toString() + "]";
        }
        return "";
    }


    // Error sub-class
    static class Error extends resultModel {
        private Exception error;

        Error(Exception error) {
            this.error = error;
        }
        Exception getError() {
            return this.error;
        }
    }
    // Success sub-class
    public static class Success<T> extends resultModel {
        private T data;
        Success(T data) {
            this.data = data;
        }
        public T getData() {
            return this.data;
        }
    }

}