FROM node:8.13 
WORKDIR /app

COPY src/ src/
COPY config/ config/
COPY package.json package.json
ENV NODE_ENV=dbpostgres
RUN npm install
ENTRYPOINT ["node","src/index.js"]