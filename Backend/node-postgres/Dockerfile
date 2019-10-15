FROM node:current-slim
WORKDIR /app

COPY src/ src/
COPY config/ config/
COPY test/ test/
COPY package.json package.json
COPY sample.json sample.json
COPY sonar-project.properties sonar-project.properties
ENV NODE_ENV=dbpostgres
RUN npm install
ENTRYPOINT ["node","src/index.js"]