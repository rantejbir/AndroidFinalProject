package com.cst2335.androidfinalproject.data;


/**
 * Author: Daksh Sharma
 * Date updated: 8/4/2023
 * purpose:The outcome of an operation, which may succeed or fail with an error, is represented by this generic
 * class, named Result.
 * This class serves as a type-safe and user-friendly means of handling success and error scenarios in code.
 */
public class Result<T> {
    // hide the private constructor to limit subclass types (Success, Error)

    @Override
    public String toString() {

        if
        (this instanceof Result.Success) {
            Result.Success success = (Result.Success) this;
            return "Success[data=" + success.getData().toString() + "]";
        } else if (this instanceof Result.Error) {
            Result.Error error = (Result.Error) this;
            return "Error[exception=" + error.getError().toString() + "]";
        }
        return "";
    }


    // Error sub-class
    public static class Error extends Result {
        private Exception error;

        public Error(Exception error) {
            this.error = error;
        }

        public Exception getError() {
            return this.error;
        }
    }
    // Success sub-class
    public static class Success<T> extends Result {
        private T data;
        public Success(T data) {
            this.data = data;
        }
        public T getData() {
            return this.data;
        }
    }

}