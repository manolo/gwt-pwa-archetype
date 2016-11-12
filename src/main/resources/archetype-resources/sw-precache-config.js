module.exports = {
  verbose: true,
  replacePrefix: '',
  navigateFallback: '',
  runtimeCaching: [{
    urlPattern: /.*/,
    handler: 'cacheFirst',
    options: {
        cache: {
          maxEntries: 500,
          name: '${artifactId}-cache'
        }
    }
  }],
  staticFileGlobs: [
    'index.html',
    'manifest.json',
    '${projectName}/${projectName}.nocache.js'
  ]
};
