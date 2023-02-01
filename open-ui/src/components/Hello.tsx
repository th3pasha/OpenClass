import { Client as Styletron } from 'styletron-engine-atomic';
import { Provider as StyletronProvider } from 'styletron-react';
import {LightTheme, BaseProvider, styled, useStyletron} from 'baseui';
import { StatefulInput } from 'baseui/input';

const engine = new Styletron();
const Centered = styled('div', {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    height: '100%',
});
export default function Hello() {
    const [css, theme] = useStyletron();
    return (
        <a
            href="/my-link"
            className={css({
                fontSize: '20px',
                color: theme.colors.primary,
            })}
        >
            Custom Link
        </a>
    );
}