# Babashka Conf Website

## Project structure
- `generate.clj` - Babashka script that generates `index.html` and `schedule.html` from hiccup templates
- `data.edn` - Data file read by the generator
- `assets/` - Logo images and other assets
- Run `./generate.clj` to regenerate the HTML after making changes

## Key technical notes
- Uses water.css (classless CSS framework) loaded from CDN. It aggressively styles elements like `img` and `p` with defaults that can be hard to override.
- CSS class selectors in `<style>` blocks do NOT reliably override water.css for images. Use inline `style` attributes directly on `<img>` tags for sizing (e.g. `:style "height: 120px; width: auto;"`).
- `<p>` tags get large default margins from water.css. Use `<div>` for text that needs to sit close to adjacent elements.
- The hiccup is written in Clojure (babashka) using hiccup2.core.

## Sponsor logos
- Sponsors are in the `[:section#sponsors ...]` block in the `index` function
- Each sponsor is a `[:div.sponsor-item ...]` containing the logo and a text element below it
- Logo sizes are controlled via inline styles on each `<img>` tag (currently `height: 120px`)
- Nubank logo requires a dark background container (`background-color: #1a1f3a`) since it's a white logo on transparent PNG
- Keep sponsor logos visually equal in size by using the same `height` value on all `<img>` tags
