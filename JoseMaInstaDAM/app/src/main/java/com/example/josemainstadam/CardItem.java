package com.example.josemainstadam;


    public class CardItem {
        private String username;
        private int userImageResource;
        private int mainImageResource;

        public CardItem(String username, int userImageResource, int mainImageResource) {
            this.username = username;
            this.userImageResource = userImageResource;
            this.mainImageResource = mainImageResource;
        }

        public String getUsername() {
            return username;
        }

        public int getUserImageResource() {
            return userImageResource;
        }

        public int getMainImageResource() {
            return mainImageResource;
        }
    }

