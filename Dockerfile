# Stage 1: Build the Vue.js application
#FROM node:18 as build-stage

# Set the working directory
#WORKDIR /app


# Copy the package.json and yarn.lock files
#COPY package*.json ./

# Install dependencies using Yarn
#RUN yarn install


# Copy the entire project
#COPY . .

# Build the Vue.js application
#RUN yarn build

# # Stage 2: Copy built files to a new stage
# FROM node:18

# # Set the working directory

# # Copy built files from the previous stage
# COPY --from=build-stage /app/.output ./.output

# Expose port
#EXPOSE 3000
#EXPOSE 80

# Command to run the application
#CMD node .output/server/index.mjs


